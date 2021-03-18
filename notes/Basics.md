# Java 基础随记

## “错误：找不到或无法加载主类”的原因以及解决办法
### 问题
在有 `package` 加包名的Java文件中，如果直接运行 `java 主类名` 会出现 `错误: 找不到或无法加载主类`。

例：
```java
package sample;

public class Hello {
    public static void main(String[] args){
        System.out.println("Hello/n");
    }
}
```
命令行运行指令:
```bash
javac Hello.java
java Hello
```
之后报错，无法运行主类 `Hello`

### 原因
Java在运行class文件时，对于有包名的类，Java把包名当作目录处理。

### 解决办法
退回上一级目录，运行 `java sample/Hello`。尝试在class文件目录下重新编译运行并不能成功，似乎只有这一种办法。

### 参考
https://www.cnblogs.com/Einsler/p/7463103.html

## Java 命令行编译运行
### 编译
编译时需要用 `-d` 参数指定 `.class` 文件的输出路径，并且需要编译所有依赖的文件。
```bash
javac -d ../bin java/algorithms/TestAlgorithms.java java/algorithms/Sort.java 
```

### 运行
运行时同样需要指定路径，参数为 `-cp` 。
```bash
java -cp ../bin algorithms.TestAlgorithms
```

## 主类和文件名
文件内只能有一个 `public class`，而且类名必须和文件名一致。

文件内其他的 class 不能被同一个包内其他的类访问到。（？）

## 异常处理
### 继承关系
```
                     ┌───────────┐
                     │  Object   │
                     └───────────┘
                           ▲
                           │
                     ┌───────────┐
                     │ Throwable │
                     └───────────┘
                           ▲
                 ┌─────────┴─────────┐
                 │                   │
           ┌───────────┐       ┌───────────┐
           │   Error   │       │ Exception │
           └───────────┘       └───────────┘
                 ▲                   ▲
         ┌───────┘              ┌────┴──────────┐
         │                      │               │
┌─────────────────┐    ┌─────────────────┐┌───────────┐
│OutOfMemoryError │... │RuntimeException ││IOException│...
└─────────────────┘    └─────────────────┘└───────────┘
                                ▲
                    ┌───────────┴─────────────┐
                    │                         │
         ┌─────────────────────┐ ┌─────────────────────────┐
         │NullPointerException │ │IllegalArgumentException │...
         └─────────────────────┘ └─────────────────────────┘
```

- `Error` 一般指严重的错误，程序无法处理
- `Exception` 一般是运行时的错误，程序可以捕获并处理


### 基本原则
#### 1
`Error` 和 `RunTimeException` 的子类必须捕获。
`Exception` 除了 RunTimeException 的子类以外不要求捕获。

#### 2
- 尽量不要捕获通用异常（`Exception`），而是捕获通用异常，便于发现问题。
- 不要忽略异常，在 `catch` 中处理异常信息。

## Java 的类型系统

```
                      ┌────┐
                      │Type│
                      └────┘
                         ▲
                         │
   ┌────────────┬────────┴─────────┬───────────────┐
   │            │                  │               │
┌─────┐┌─────────────────┐┌────────────────┐┌────────────┐
│Class││ParameterizedType││GenericArrayType││WildcardType│
└─────┘└─────────────────┘└────────────────┘└────────────┘
```

## PECS原则
Producer Extends, Consumer Super

如果需要返回T，它是生产者（Producer），要使用 `extends` 通配符；如果需要写入T，它是消费者（Consumer），要使用 `super` 通配符。

### 例：`Collection` 的 `copy()`

```java
public class Collections {
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i=0; i<src.size(); i++) {
            T t = src.get(i); // src是producer
            dest.add(t); // dest是consumer
        }
    }
}
```

需要返回 `T` 的 `src` 是生产者，因此声明为 `List<? extends T>` ，需要写入 `T` 的 `dest` 是消费者，因此声明为 `List<? super T>`。

## 编写 `equals()` 方法

### 基本原则
- 自反性（Reflexive）：对于非`null`的x来说，`x.equals(x)`必须返回`true`；
- 对称性（Symmetric）：对于非`null`的`x`和`y`来说，如果`x.equals(y)`为`true`，则`y.equals(x)`也必须为`true`；
- 传递性（Transitive）：对于非`null`的`x`、`y`和`z`来说，如果`x.equals(y)`为`true`，`y.equals(z)`也为`true`，那么`x.equals(z)`也必须为`true`；
- 一致性（Consistent）：对于非`null`的`x`和`y`来说，只要`x`和`y`状态不变，则`x.equals(y)`总是一致地返回`true`或者`false`；
- 对null的比较：即`x.equals(null)`永远返回`false`。
  
### 编写方法
1. 先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
2. 用instanceof判断传入的待比较的`Object`是不是当前类型，如果是，继续比较，否则，返回`false`；
3. 对引用类型用`Objects.equals()`比较，对基本类型直接用==比较。

使用`Objects.equals()`比较两个引用类型是否相等的目的是省去了判断`null`的麻烦。两个引用类型都是`null`时它们也是相等的。

## 编写 `hashCode()` 方法

对类的成员分别使用他们的类的 `hashCode()` 方法

## Java 中的线程

### 线程状态
- New：新创建的线程，尚未执行；【就绪态】
- Runnable：运行中的线程，正在执行`run()`方法的Java代码；【运行态】
- Blocked：运行中的线程，因为某些操作被阻塞而挂起；【阻塞态】
- Waiting：运行中的线程，因为某些操作在等待中；
- Timed Waiting：运行中的线程，因为执行`sleep()`方法正在计时等待；
- Terminated：线程已终止，因为`run()`方法执行完毕。