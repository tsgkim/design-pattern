package com.tsgkim.chapter3.waitAndNotify;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 使用管道实现不同线程间的通信，无须借助于临时文件
 *
 * @author: shiguang.tu
 * @create: 2018/11/28 7:22 PM
 */
public class Piped {

    /**
     * 字节流写
     */
    public void writeByByteStream(PipedOutputStream pipedOutputStream) throws IOException {

        for (int i = 0; i < 10; i++) {

            pipedOutputStream.write(String.valueOf(i).getBytes());

            System.out.println(String.format("Write value=%s", i));
        }

        pipedOutputStream.close();

    }

    /**
     * 字符流写
     */
    public void writeByCharacterStream(PipedWriter pipedWriter) throws IOException {

        for (int i = 0; i < 10; i++) {

            pipedWriter.write(String.valueOf(i));

            System.out.println(String.format("Write value=%s", i));
        }

        pipedWriter.close();

    }

    /**
     * 字节流读
     */
    public void readByByteStream(PipedInputStream pipedInputStream) throws IOException {

        byte[] bytes = new byte[20];

        int readLength = pipedInputStream.read(bytes);

        while (readLength != -1) {

            String s = new String(bytes, 0, readLength);

            System.out.println(String.format("Read value=%s", s));

            readLength = pipedInputStream.read(bytes);

        }

        pipedInputStream.close();

    }

    /**
     * 字符流读
     */
    public void readByCharacterStream(PipedReader pipedReader) throws IOException {

        char[] chars = new char[20];

        int readLength = pipedReader.read(chars);

        while (readLength != -1) {

            String s = new String(chars, 0, readLength);

            System.out.println(String.format("Read value=%s", s));

            readLength = pipedReader.read(chars);

        }

        pipedReader.close();

    }



    @Test
    public void myTest() throws IOException, InterruptedException {

        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();
        pipedInputStream.connect(pipedOutputStream);

        Piped piped = new Piped();

        new Thread(() -> {

            try {
                piped.writeByByteStream(pipedOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

        Thread.sleep(2000);

        new Thread(() -> {

            try {
                piped.readByByteStream(pipedInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

    }

    @Test
    public void myTest2() throws IOException, InterruptedException {

        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        pipedWriter.connect(pipedReader);

        Piped piped = new Piped();

        new Thread(() -> {

            try {
                piped.writeByCharacterStream(pipedWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

        Thread.sleep(2000);

        new Thread(() -> {

            try {
                piped.readByCharacterStream(pipedReader);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

    }


}

