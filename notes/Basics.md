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
