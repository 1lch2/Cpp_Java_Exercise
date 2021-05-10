# 设计模式
## 目录
- [设计原则](#设计原则)
- [创建型](#创建型)
	- [工厂模式](#工厂模式)
	- [静态工厂](#静态工厂)
	- [抽象工厂](#抽象工厂)
	- [单例](#单例)
	- [生成器](#生成器)
- [结构型](#结构型)
	- [适配器](#适配器)
	- [装饰器](#装饰器)
	- [代理](#代理)
	- [享元](#享元)
- [行为型](#行为型)
	- [迭代器](#迭代器)
	- [观察者](#观察者)
	- [模板](#模板)


## 设计原则
1. 单一职责原则（SRP）
   全称Single Responsibility Principle，即一个类应该只有一个职责，应当只有一个引起它变化的原因。
   **实现类要职责单一**：
   如果一段代码块（函数 类 模块）负责多个功能，那么当 A 功能需求发生改变的时候改动了代码，就有可能导致 B 功能出现问题，所以一段代码块只应该负责一个职责。
   例：Android的MVP开发模式。

2. 开放-封闭原则（OCP）
   全称Open-Closed Principle。
   **一个实体要对扩展开放，对修改关闭**：
   通过修改老代码来实现新功能可能导致老模块出现 BUG，所以我们应该通过开发新代码块来实现新功能，而不是修改原有的代码。

3. 里氏替换原则（LSP）
   全称Liskov Substitution Principle。
   在所有引用基类的地方必须能替换成其子类，而且换成子类不会导致错误或异常。

4. 接口隔离原则（ISP）
   全称Interface Segregation Principle。
   接口隔离原则有两种定义：
   一种是客户端不应该依赖它不需要的接口，另一种是类的依赖关系应该建立在最少的接口上。
   两种定义都表达了同一个意思，即减少不必要的依赖。

5. 依赖倒置原则（DIP）
   全称Dependency Inversion Principle。
   依赖倒置原则定义有两条：
	1. 上层模块不应该依赖底层模块，他们都应该依赖于抽象。
	2. 抽象不应该依赖于细节，而是细节依赖于抽象。

6. 迪米特法则（LoD）
   全称Law of Demeter, a.k.a. 最少知识原则（Least Knowledge Principle）。
   **一个对象应该对其他对象有最少的了解**。
   该法则包含两层意思：
   一是只和需要耦合的对象交流，二是对耦合的对象保持最少的了解。
   对于第一条，具体解释如下：
	- 一个类中的方法可以访问本类中的其他方法
	- 一个类中的方法可以访问本类中的字段，但不能访问字段的字段
	- 在方法中可以直接访问其参数的方法
	- 在方法中创建的局部变量，可以访问局部变量的方法
	- 在方法中不应该访问全局对象的方法(能否作为参数传递进来)
	  对于第二条，需要控制好访问的权限，只暴露应该暴露的功能，减少外部能访问到的成员和方法。



## 创建型
### 工厂模式
[返回目录](#目录)
#### 目的
工厂模式使创建对象和使用对象的过程分离开，且客户端总是引用抽象工厂和抽象产品。
通过向工厂传递类型来指定要创建的对象。

#### 实现
以手机类`Phone`为例。
规范类：
```java
public interface Phone {
	void make();
}
```


具体实现类：
```java
/** iPhone类 */
public class IPhone implements Phone {
	public IPhone() {
		this.make();
	}

	@Override
	public void make() {
		// Make a phone here.
	}
}

/** MiPhone类 */
public class MiPhone implements Phone {
	public MiPhone() {
		this.make();
	}

	@Override
	public void make() {
		// Make a phone.
	}
}
```


工厂类：
```java
public class PhoneFactory {
    public Phone makePhone(String phoneType) {
        if(phoneType.equalsIgnoreCase("MiPhone")){
            return new MiPhone();
        }
        else if(phoneType.equalsIgnoreCase("iPhone")) {
            return new IPhone();
        }
        return null;
    }
}
```


使用工厂创建对象的代码如下：
```java
PhoneFactory phoneFactory = new PhoneFactory();
Phone MiPhone = phoneFactory.makePhone("miphone"); // 返回类型为Phone
IPhone iPhone = (IPhone)phoneFactory.makePhone("iphone") // 强制转型返回IPhone类型
```


---
### 静态工厂
[返回目录](#目录)
实际情况中，并不需要创建复杂的工厂，而是通过一个静态的工厂方法来返回对象。这种使用静态工厂方法创建产品的的方式叫做静态工厂方法（Static Factory Method）。
静态工厂有很多优势：
1. 可以有多个参数相同但名称不同的工厂方法
   可以直接通过方法名来区分功能，使代码更清晰明了。
2. 可以减少对外暴露的属性
   通过预先定义的构造函数参数来限定调用者
   代码示例如下：
   ```java
   public class Player {
       private static final int TYPE_RUNNER = 1;
       private static final int TYPE_SWIMMER = 2;
       private static final int TYPE_RACER = 3;
       private int type;

       private Player(int type) {
           this.type = type;
       }

       public static Player newRunner() {
           return new Player(TYPE_RUNNER);
       }
       public static Player newSwimmer() {
           return new Player(TYPE_SWIMMER);
       }
       public static Player newRacer() {
           return new Player(TYPE_RACER);
       }
   }
   ```
3. 多了一层控制，方便统一修改


---
### 抽象工厂
[返回目录](#目录)
抽象工厂模式中，不仅工厂是抽象的，产品也是抽象的。相比于工厂方法，抽象工厂模式中的工厂是类而不是方法。
#### 目的
减少大量的一系列产品对象创建所需的重复代码，提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
这些产品属于一系列产品族，每个产品族对应一个具体工厂，而抽象工厂对应每个产品族中的不同产品线。


类比如下：
一个品牌可以有多条产品线，而市场上可以有多个拥有同类型产品线的不同品牌。此处的每个品牌就是具体的工厂，工厂内的不同产品线对应不同的实现类，而抽象工厂就是对品牌的抽象。


#### 实现
此处以华为和小米为产品品牌，各自拥有自己的手机和路由器产品线。
首先定义抽象的手机产品和路由器产品接口，然后为两个牌子各自实现具体产品类。
之后根据产品线定义抽象工厂，为两个品牌各自定义生产各自产品的工厂类。


代码示例如下：


抽象产品接口：
```java
/**
 * 抽象手机产品接口
 */
public interface PhoneProduct {

    void boot();
    void run();
    void shutdown();
}

/**
 * 抽象产品工厂
 */
public interface ProductFactory {

    PhoneProduct makePhone();
    RouterProduct makeRouter();
}
```


具体产品实现类(此处只贴一个牌子的实现)：
```java
public class MiPhone implements PhoneProduct {

    @Override
    public void boot() {
        System.out.println("Mi phone boot up.");
    }

    @Override
    public void run() {
        System.out.println("Are U OK?");
    }

    @Override
    public void shutdown() {
        System.out.println("Mi phone shutdown.");
    }
}


public class MiRouter implements RouterProduct {

    @Override
    public void powerOn() {
        System.out.println("Mi router running");
    }

    @Override
    public void wifiOn() {
        System.out.println("Mi router WiFi up and running.");
    }

    @Override
    public void powerOff() {
        System.out.println("Mi router power off.");
    }
}
```


抽象工厂接口：
```java
public interface ProductFactory {

    PhoneProduct makePhone();
    RouterProduct makeRouter();
}
```


工厂的实现类(同样只举一个例子)：
```java
public class MiProductFactory implements ProductFactory {

    @Override
    public PhoneProduct makePhone() {
        System.out.println("Mi factory making phone.");
        return new MiPhone();
    }

    @Override
    public RouterProduct makeRouter() {
        System.out.println("Mi factory making router.");
        return new MiRouter();
    }
}
```

使用时的方法：
```java
// 小米工厂实例
ProductFactory miFactory = new MiProductFactory();

//生产小米路由器
RouterProduct miRouter = miFactory.makeRouter();

//生产小米手机
PhoneProduct miPhone = miFactory.makePhone();

//华为产品工厂实例
ProductFactory huaweiFactory = new HuaweiProductFactory();

//生产华为路由器
RouterProduct huaweiRouter = huaweiFactory.makeRouter();

//生产华为手机
PhoneProduct huaweiPhone = huaweiFactory.makePhone();
```




---
### 单例
[返回目录](#目录)
#### 目的
单例用来避免资源访问的冲突，保证一个类仅有一个实例，并提供一个全局访问的点


#### 实现
经典写法如下：
```java
public class Singleton {
    // 静态字段引用唯一实例:
    private static final Singleton INSTANCE = new Singleton();

    // 通过静态方法返回实例:
    public static Singleton getInstance() {
        return INSTANCE;
    }

    // private构造方法保证外部无法实例化:
    private Singleton() {}
}
```
通过`Singleton.getInstance()`来获取类的唯一实例。
> 在释放单例资源时，应该定义一个静态的`release()`方法，在方法内判断对象是否已经创建，避免对未创建的对象做重复操作。


---
### 生成器
[返回目录](#目录)


#### 问题背景
对于有多个构造参数且部分参数可选的类，通常情况下下，可以选择用重叠构造器的办法。
这种模式下，第一个构造器只有必要的参数，第二个多包含一个可选参数，之后类推。但是这种模式在遇到参数较多的情况时会导致代码难以阅读。代码示例如下：
```java
public class NutritionFacts {

    private final int servingSize;  // Required
    private final int calories;     // Required
    private final int fat;          // Optional
    private final int sodium;       // Optional
    
    public NutritionFacts(int servingSize, int calories) {
        this(servingSize, calories, 0, 0);
    }

    public NutritionFacts(int servingSize, int calories, int fat) {
        this(servingSize, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int calories, int fat, int sodium) {
        this.servingSize = servingSize;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
    }
}
```


一种解决办法是使用JavaBean模式，使用setter来设置参数，代码示例如下：
```java
public class NutritionFacts {
    
    private int servingSize;  // Required
    private int calories;     // Required
    private int fat;          // Optional
    private int sodium;       // Optional

    public NutritionFacts() {}

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }
}
```


这种方法弥补了构造器模式的不足，代码也容易阅读。但是在构造过程中，JavaBean可能处于不一致的状态，而且无法将类变为不可变的。


**总结这类创建对象的问题场景**：
- 创建时有很多必填参数需要验证。
- 创建时参数求值有先后顺序、相互依赖。
- 创建有很多步骤，全部成功才能创建对象。




#### 解决方案
构造器模式（Builder）不直接生成想要的对象，而是让客户端（创建对象的那一方）利用所有必要的参数调用构造器，得到一个`builder`对象。然后在`builder`上调用类似setter的方法来设置每个可选参数。最后，客户端调用无参的`build()`方法来生成对象（通常为不可变）。代码示例如下：
```java
public class NutritionFacts {

    private final int servingSize;  // Required
    private final int calories;     // Required
    private final int fat;          // Optional
    private final int sodium;       // Optional

    public static class Builder {

        // Required
        private final int servingSize;
        private final int calories;

        // Optional
        private int fat = 0;
        private int sodium = 0;

        // Constructor with required parameters
        public Builder(int servingSize, int calories) {
            this.servingSize = servingSize;
            this.calories = calories;
        }

         public Builder fat(int val) {
            fat = val;
            return this;
         }

         public Builder sodium(int val) {
            sodium = val;
            return this;
         }

         public NutritionFacts build() {
            return new NutritionFacts(this);
         }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
    }
}
```
`NutritionFacts`本身是不可变的，通过链式调用`builder`的方法来创建对象。代码示例如下：
```java
NutritionFacts coke = new Builder(200, 8)
        .fat(0)
        .sodium(35)
        .build();
```

生成器模式也有不足。为了创建对象，必须先创建它的生成器。在某些注重性能的场景下可能会造成问题。生成器模式应该在一开始就有很多参数的情况下使用，或未来可能会添加新参数的情况。

---
## 结构型

### 适配器
[返回目录](#目录)
适配器模式可以将A接口转换为B接口，使得新的对象符合B接口的规范。
适配器具有较好的复用性，而且符合上文提到的开放-封闭原则（OCP）。通过适配器可以将目标和被适配类解耦，无需修改源代码。
#### 目的
适配器模式定义一个包装类，用于将不兼容的接口的对象包装起来，以符合目标的接口要求。
适配器模式按照实现不同可以分为**类适配器**和**对象适配器**。


以普通3.5mm耳机转接iPhone为例。
首先定义拥有传统3.5mm音频接口的设备
```java
public class AudioDevice {

    public void transferAudio() {
        System.out.println("Audio transfer in progress.");
    }
}
```


然后定义Lightning接口
```java
public interface LightningJack {
    void lightningAudio();
}
```


这里再额外定义一个需要使用实现了Lightning接口的对象的类
```java
public class IPhone {

    public void play(LightningJack earpiece) {
        earpiece.lightningAudio();
    }
}
```


#### 类适配器
类适配器将被适配类的API转换为目标类的API。
实现类适配器需要实现一个继承被适配类且实现目标接口的类。代码示例如下。

```java
public class AudioWrapLightningAdapter extends AudioDevice implements LightningJack {

    @Override
    public void lightningAudio() {
        System.out.println("[Class adapter] Passing audio from 3.5mm jack to lightning jack.");

        // Convert method to suit target API
        this.transferAudio();
    }
}
```
适配器通过继承被转换类和实现目标接口，实现了对被适配类的转换。
这里将被适配类的对应方法直接包装成了目标所需的方法。


#### 对象适配器
对象适配器与类适配器不同之处在于，对象适配器只实现目标接口，不继承被适配类。对象适配器通过委派关系和被适配的类关联起来。
代码示例如下：
```java
public class AudioToLightningAdapter implements LightningJack {

    private AudioDevice audioDevice;

    public AudioToLightningAdapter(AudioDevice audioDevice) {
        this.audioDevice = audioDevice;
    }

    @Override
    public void lightningAudio() {
        System.out.println("[Object adapter] Passing audio from plugged 3.5mm jack to lightning.");
        this.audioDevice.transferAudio();
    }
}
```


#### 使用
以为IPhone类提供一个传统3.5mm接口耳机设备为例，代码如下。
```java
IPhone iPhone = new IPhone();
AudioToLightningAdapter objectAdapter = new AudioToLightningAdapter(new AudioDevice());
iPhone.play(objectAdapter); // Lightning device required by iPhone.
objectAdapter.lightningAudio();
```
通过适配器，将原本AudioDevice的类功能提供给了需要LightningJack接口的方法`play()`。


---
### 装饰器
[返回目录](#目录)
装饰器（Decorator）模式，是一种在运行期动态给某个对象的实例增加功能，同时不改变其结构的设计模式。

#### 问题背景
一个继承的体系中，各个子类之间的关系往往是互斥的。但是有一些功能对于这些互斥的子类却是共同的。如果为了给每个不同的子类添加相同的功能，就会产生大量的重复代码，而且新增的功能与各个子类相耦合，很难维护。
装饰器就是为了给不同子类添加功能，同时不影响他们原本的功能的一种设计模式。


#### 实现过程
此处以为车增加喷漆装饰为例。

首先定义车的接口以及一个实现。
```java
public interface Car {
    void didi();
}
```


```java
public class Audi implements Car {

    @Override
    public void didi() {
        System.out.println("[Audi] Didi from Audi car.");
    }
}
```


然后定义实现车接口的装饰器类
```java
public class Decorator implements Car {

    public Car car;

    public Decorator(Car car) {
        this.car = car;
    }

    @Override
    public void didi() {
        this.car.didi();
    }
}
```


最后通过继承装饰器类来定义具体的装饰类
```java
public class PaintDecorator extends Decorator {

    public PaintDecorator(Car car) {
        super(car);
    }

    @Override
    public void didi() {
        System.out.println("[Paint] Car painted.");
        super.didi();
    }
}
```


#### 使用
实例化任意一个车的实现类，通过传入装饰器来为车添加功能
```java
Car car = new PaintDecorator(new Audi());
car.didi();
```
运行结果如下
```
// [Paint] Car painted.
// [Audi] Didi from Audi car.
```

---
### 代理
[返回目录](#目录)
代理模式为其他对象提供了一种代理对象，客户端通过代理对象访问方法。代理模式原理类似适配器模式，但是实现的类和目标类的接口一致。
代理对象起到了隔离作用，同时也符合[开放封闭原则](#设计原则)，只需要通过对代理类的修改就可以扩展委托类的功能。
#### 实现过程
首先定义抽象的接口类。
```java
public interface Vehicle {
    void move();
}
```


定义实现接口的类
```java
public class Automobile implements Vehicle {

    @Override
    public void move() {
        System.out.println("[Automobile] Moving.");
    }
}
```


定义代理类，此处通过组合方式。定义类实现`Vehicle`接口，传入被代理的类，由此调用到目标方法。
除此之外还可以通过继承目标类，再通过`super`引用目标方法的方式来实现代理类，此处不展示。
```java
public class AutomobileProxy implements Vehicle {

    private Automobile automobile;

    public AutomobileProxy(Automobile automobile) {
        this.automobile = automobile;
    }

    @Override
    public void move() {
        // 此处类似AOP，为原本的方法增加其他功能，如权限检查等
        System.out.println("[Proxy] Proxy runs.");
        this.automobile.move();
    }
}
```

之后只通过代理类来访问原本类的方法。
```java
Vehicle car = new AutomobileProxy(new Automobile());
car.move();
```


---
### 享元
[返回目录](#目录)



---
## 行为型
### 迭代器
[返回目录](#目录)



---
### 观察者
[返回目录](#目录)

观察者模式（Observer）又称发布-订阅模式（Publish-Subscribe：Pub/Sub）。它是一种通知机制，让发送通知的一方（被观察方）和接收通知的一方（观察者）能彼此分离，互不影响。
#### 问题背景
观察者模式主要用于一对多的场景，也就是一个对象的事件需要通知到多个其他对象。通过引入观察者列表，避免了直接在发布信息的客户端应用被通知对象，从而将发送信息的一方和接收的一方分离开。

#### 实现过程
以商店和订阅商店消息的消费者为例。


首先定义抽象的观察者和被观察者接口：
```java
/**
 * 抽象观察者接口
 */
public interface ProductObservable {

    /**
     * 增加观察者
     *
     * @param observer 被添加的观察者对象
     */
    void addObserver(ProductObserver observer);

    /**
     * 移除观察者
     *
     * @param observer 被移除的观察者对象
     */
    void removeObserver(ProductObserver observer);
}
```


```java
/**
 * 抽象观察者接口
 */
public interface ProductObserver {

    /**
     * 注册的观察者在接受到事件时触发的动作
     *
     * @param event 触发观察者动作的事件
     */
    void onEvent(ProductEvent event);
}
```


接着，定义商品类，也就是一个简单的JavaBean。
```java
public class Product {

    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
```


为了统一传递的消息，将消息定义为统一的一个对象，实现如下。
```java
public class ProductEvent {

    /** 新商品上架 */
    public static final String NEW_PRODUCT_EVENT = "subscribe";
    /** 商品价格变动 */
    public static final String PRICE_CHANGE_EVENT = "price_change";

    /** 事件类型 */
    private String event;

    private ProductEvent(String event) {
        this.event = event;
    }

    public String getEventType() {
        return event;
    }

    public static ProductEvent newProductEvent(){
        return new ProductEvent(NEW_PRODUCT_EVENT);
    }

    public static ProductEvent newPriceEvent() {
        return new ProductEvent(PRICE_CHANGE_EVENT);
    }
}
```


最后，定义实现被观察者接口的商店实体类。
```java
/**
 * 实现了观察者模型的商店类
 * <p>
 * 商店可以注册一系列订阅者（观察者），商店商品发生变动时发送通知给所有订阅者。
 */
public class Store implements ProductObservable {

    /** 订阅者列表 */
    private List<ProductObserver> subscribers = new ArrayList<>();
    /** 商品列表 */
    private Map<String, Product> products = new HashMap<>();

    @Override
    public void addObserver(ProductObserver observer) {
        this.subscribers.add(observer);
        System.out.println("[Store] New subscriber " + observer.getClass().getSimpleName() + " added.");
    }

    @Override
    public void removeObserver(ProductObserver observer) {
        this.subscribers.remove(observer);
        System.out.println("[Store] Subscriber " + observer.getClass().getSimpleName() + " removed.");
    }

    /**
     * 添加新商品并通知订阅者
     *
     * @param product 被添加的新商品
     */
    public void addNewProduct(Product product) {
        this.products.put(product.getName(), product);

        // 发送新增商品事件通知所有订阅者
        subscribers.forEach(o -> o.onEvent(ProductEvent.newProductEvent()));
    }

    public void setProductPrice(String name, int price) {
        Product changedProduct = products.get(name);
        changedProduct.setPrice(price);

        // 发送商品价格变化事件通知所有订阅者
        subscribers.forEach(o -> o.onEvent(ProductEvent.newPriceEvent()));
    }
}
```


之后如果需要增加事件类型，只需要对`ProductEvent`类进行修改即可，不需要额外修改其他类。


---
### 模板
[返回目录](#目录)



定义一个操作中的算法的骨架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。


#### 问题场景
有一些过程需要的步骤结构固定，但是实现细节不同，需要通过固定框架但不固定细节的方式在子类中实现不同的细节。


#### 实现过程
首先定义一个算法的过程以及分解出来可能有不同实现的步骤。
```java
public abstract class FirearmsReload {

    protected abstract void unloadMagazine();
    protected abstract void swapMagazine();
    protected abstract void loadMagazine();
    protected abstract void pullBoltHandle();

    public void reload() {
        System.out.println("Starting reloading.");

        unloadMagazine();
        swapMagazine();
        loadMagazine();
        pullBoltHandle();

        System.out.println("Gun reloaded.");
    }
}
```


通过一个子类继承这个抽象类，并实现抽象方法，来实现不同的过程。
```java
public class PistolReload extends FirearmsReload{

    @Override
    protected void unloadMagazine() {
        System.out.println("[Pistol] Unload pistol magazine.");
    }

    @Override
    protected void swapMagazine() {
        System.out.println("[Pistol] Swap pistol mag.");
    }

    @Override
    protected void loadMagazine() {
        System.out.println("[Pistol] Fresh magazine going in.");
    }

    @Override
    protected void pullBoltHandle() {
        System.out.println("[Pistol] Pulling pistol sleeve.");
    }
}
```

在模板方法模式中可以通过子类来覆盖父类的基本方法，不同的子类可以提供基本方法的不同实现，更换和增加新的子类很方便，符合单一职责原则和开闭原则。

> 缺点：需要为每一个基本方法的不同实现提供一个子类，如果父类中可变的基本方法太多，将会导致类的个数增加，系统更加庞大，设计也更加抽象，此时，可结合桥接模式来进行设计。


