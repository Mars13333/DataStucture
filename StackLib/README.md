Stack
    栈是一种线性结构
    相比数组，栈对应的操作是数组的子集，相应的操作更少：
    只能从一端添加元素，也只能从同一端取出元素
    这一端称为栈顶
    是数组操作的子集，是非常简单的
    栈是一种后进先出的数据结构 Last in First out LIFO
    在计算机世界里，栈拥有者不可思议的作用

栈的应用
    无处不在的Undo操作(撤销) 各种编辑器里面的操作
    程序调用的系统栈(子函数的调用) (理解递归)

栈的实现
    Stack<E>
    void push(E)        入栈(添加元素)
    E pop()             出栈(删除栈顶)
    E peek()            查看栈顶
    int getSize()
    boolean isEmpty()
    栈的基本操作
    实际的底层实现有多种实现方式

    为了让逻辑清晰，支持面向对象的特性比如多态型。基于动态数组的实现方式：
    Interface Stack<E>              <---------         ArrayStack<E>
    void push(E)                    implements
    E pop()
    E peek()
    int getSize()
    boolean isEmpty()

    时间复杂度
    ArrayStack<E>
    void push(E)        O(1)均摊
    E pop()             O(1)均摊
    E peek()            O(1)
    int getSize()       O(1)
    boolean isEmpty()   O(1)