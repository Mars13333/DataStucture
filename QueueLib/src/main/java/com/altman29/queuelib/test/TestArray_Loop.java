package com.altman29.queuelib.test;

import com.altman29.queuelib.array_queue.ArrayQueue;
import com.altman29.queuelib.base.Queue;
import com.altman29.queuelib.loopqueue.LoopQueue;

import java.util.Random;

/**
 * Created by Csy on 2018/11/21.
 * e-mial:chensiyuan@duozhuan.cn
 * Desc:    测试ArrayQueue 和LoopQueue 耗时区别。  sss
 */
public class TestArray_Loop {

    /**
     * 获取耗时
     *
     * @param q       目标队列
     * @param opCount 操作次数
     * @return
     */
    public static double getTime(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();//开始时间   nanoTime 纳秒级别。  与秒  差 10的9次方

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i++)
            q.dequeue();

        long endTime = System.nanoTime();//结束时间

        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        int opCount = 100000;//10万次

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = getTime(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = getTime(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");


        /*
        数据结构的魅力。 10万级入队出队操作，ArrayQueue耗时3.6s，LoopQueue耗时0.01s。！！ 100倍！ 别尝试100万。。。。
         */
    }
}
