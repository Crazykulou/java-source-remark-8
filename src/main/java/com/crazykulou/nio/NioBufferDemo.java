package com.crazykulou.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioBufferDemo {

    public static void main(String[] args) throws IOException {
        testCopyFile();
    }

    private static void testWrite() throws IOException {
        FileOutputStream fos = new FileOutputStream("testNio.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
            System.out.println("write : " + (byte) i);
        }
        buffer.flip();
        channel.write(buffer);
        fos.close();
    }

    private static void testRead() throws IOException {
        FileInputStream fis = new FileInputStream("testNio.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            int n = channel.read(buffer);
            System.out.println("read..." + n);
            if (n == -1) {
                break;
            }
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println("read: " + buffer.get());
        }
        fis.close();
    }

    private static void testCopyFile() throws IOException {
        FileInputStream fis = new FileInputStream("testNio.txt");
        FileOutputStream fos = new FileOutputStream("testNioCopy.txt");
        FileChannel inChannel = fis.getChannel();
        FileChannel outChanel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(3);
        while (true) {
            int n = inChannel.read(buffer);
            System.out.println("n = " + n);
            if (n == -1) {
                break;
            }
            buffer.flip();
            outChanel.write(buffer);
            buffer.clear();
        }
    }

    private static void testSlice() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(6);
        for (int i = 0; i < 6; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.clear();
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
        System.out.println("---------");
        byteBuffer.position(2);
        byteBuffer.limit(4);
        ByteBuffer slice = byteBuffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            slice.put((byte) (slice.get(i) * 10));
        }
        byteBuffer.clear();
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }
}
