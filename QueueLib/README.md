队列 Queue Q
    队列也是一种线性结构
    相比数组，队列对应的操作也是数组的子集
    只能从一段(队尾)添加元素，只能从另一端(队首)取出元素

队列的实现 其实与栈是对应的，只不过换了一种说法。 还是基于动态数组实现。
    Queue<E>
    void enqueue<E>         添加元素    入队(相当于栈的push)
    E dequeue()             取出元素    出队(相当于栈的pop)
    E getFront()            查看队首    查看(相当于栈的peek)
    int getSize()
    boolean isEmpty()

    Interface Queue<E>            <-----------      ArrayQueue<E>
        void enqueue<E>             implements
        E dequeue()
        E getFront()
        int getSize()
        boolean isEmpty()

时间复杂度           数组队列的局限性(问题)：数据量大的情况下。出队会很抵消
    Queue<E>
    void enqueue<E>                 O(1)均摊
    E dequeue()                     O(n) 如果是100W的大小，出队一次，就会很久很久才能结束，因为，队列会往前移一位。(循环队列可解决这个问题)
    E getFront()                    O(1)
    int getSize()                   O(1)
    boolean isEmpty()               O(1)

循环队列的实现 LoopQueue  不使用动态数组实现，使用java提供的数组实现 扩容，入队，出队
    LoopQueue<E>
    void enqueue<E>                 O(1)均摊
    E dequeue()                     O(1)均摊！！！
    E getFront()                    O(1)
    int getSize()                   O(1)
    boolean isEmpty()               O(1)