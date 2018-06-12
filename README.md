# Small programs to introduce to Java 

In this repository is designed to show small projects created in Java, I would recommend that you start using a basic interactive development environment (IDE) to avoid using the "shortcuts" given by them, or you can start with VIM or Emacs, I find them an excellent options to start and learn to program in any language from scratch.

## Installing Java

To install Java you must enter the page [Java JDK](http://www.oracle.com/technetwork/es/java/javase/downloads/index.html) and choose the operating system in which you work, it's simple.. 


### Starting with Java
We will create, as tradition says, a hello world.

First we open the terminal, and we move to the folder where we want to create our small program.

```
➜ ~ cd Documents/Java

```
Then we create a new document, either with vim or simply using *touch Hello_World.java*

```
➜ ~ vim Hello_World.java

```

The first thing we will have to do in Java will be the HelloWorld class.
```java
public class HelloWorld {
 
}
~
~
~
~
```
Then a main class, which is what runs first.

```java
public class HelloWorld {
  public static void main(String[] args) {
  
  }
}
~
~
~
```
We only have to show the text "Hello World" by the console. For this we will use the static class System.out. This class allows us to access the output of the console. 

```java
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hola Mundo");
  }
}
~
~
```
Finally we save it and to compile and execute in terminal we will have to execute the following sentences

```
➜ ~ javac Hello_World.java
➜ ~ java Hello_World

```
There you have it, your first Java program. Congratulations. Remember not to copy this repository if they left you with a similar school assignment, use it better as a guide, as long as you understand it.
