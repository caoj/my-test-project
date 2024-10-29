1.ThreadLocal 是 Java 中的一种机制，用于为每个线程提供独立的变量副本。这样每个线程都可以独立地更改自己的副本，而不会影响其他线程的副本。

2.InheritableThreadLocal 是 ThreadLocal 的一个变体，它允许子线程(创建时)继承父线程的值。这在需要将线程上下文信息传递给子线程时非常有用。

3.TransmittableThreadLocal 是 Java 中的一个特殊的线程局部变量（ThreadLocal）类，它可以在不同线程之间传递值。与普通的 ThreadLocal 不同，TransmittableThreadLocal 允许你在创建新线程时将当前线程的值传递给新线程。

总结: InheritableThreadLocal 和 TransmittableThreadLocal 是用于在父线程和子线程之间传递上下文信息的工具，但它们有一些重要的区别。

InheritableThreadLocal
功能: 允许子线程继承父线程的 ThreadLocal 值。
局限性: 只在子线程创建时继承父线程的值。如果父线程的值在子线程创建后发生变化，子线程不会感知到这些变化。
TransmittableThreadLocal
功能: 由阿里巴巴开源的 TransmittableThreadLocal 解决了 InheritableThreadLocal 的局限性。它不仅在子线程创建时继承父线程的值，还可以在使用线程池等场景中传递上下文。
优势:
支持线程池：在使用线程池时，能够在任务提交时传递父线程的上下文到执行线程。
动态更新：能够在父线程修改值后，动态更新子线程的上下文。