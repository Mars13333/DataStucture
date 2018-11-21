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

栈的应用
    Undo操作-编辑器
    系统调用栈-操作系统

    括号匹配-编辑器(如果不匹配就会报错)

    引用LeetCode的栗子解决 括号匹配 问题。  Leetcode-cn.com 第20题

    分析
    声明一个栈
    逐一遍历字符串中每个字符，如果这个字符是哥左括号就压入栈(不管是大括中括还是小括)
    如果遍历到一个右括，那就看栈顶是不是对应的左括，如果匹配成功，就把栈顶出栈
    若栈内为空的，证明当前字符串是括号匹配的。
    在上述分析中可以得出：栈顶元素反映了在嵌套的层级关系中，最近的需要匹配的元素。！！！