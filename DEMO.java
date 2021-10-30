
import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import java.math.BigInteger;
import java.util.zip.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.*;
import static java.lang.Thread.sleep;

public class HttpServlett {

public static byte[] intToByteArray(int a) {
        return new byte[] {
            (byte) ((a >> 24) & 0xFF),
            (byte) ((a >> 16) & 0xFF),   
            (byte) ((a >> 8) & 0xFF),   
            (byte) (a & 0xFF)
        };
    }

    public static void main(String[] args) throws Exception{
        ExecutorService CORE_THREAD                    = Executors.newFixedThreadPool(10);
//for (int i0 = 0;i0 < 5;i0++) {
        //for (;;) {
            CORE_THREAD.execute(() -> {
                try (Socket socket = new Socket()) {
                    //socket.connect(new InetSocketAddress(InetAddress.getByName("192.168.0.101"), 5123), 5123);
                    IoOutputStream o = new IoOutputStream();
                    o.writeString("com.corrodinggames.rts");
                    o.writeInt(1);
                    o.writeInt(151);
                    o.writeInt(151);
            
                    readServer(socket,161,null);
                    //sleep(10000);
                    //
                } catch(Exception e) {}
                System.exit(1);
            });
                //}

        
}

    public static Object[] readServer(Socket socket, int type, Object[] pam) throws Exception {
        while (!socket.isClosed()) {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                int size = in.readInt();
                Packet packet = new Packet(in.readInt());
                packet.bytes = new byte[size];
                int bytesRead = 0;
                while (bytesRead < size) {
                    int readIn = in.read(packet.bytes, bytesRead, size - bytesRead);
                    if (readIn == -1) {
                        break;
                    }
                    bytesRead += readIn;
                }
                    System.out.println(packet.type);

                int result = doActive(socket,packet,type,pam);
                if(result == 0) return null;
                //Log.info(result);
                
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static int doActive(Socket socket, Packet packet, int type, Object[] pam) throws Exception {
        // 0完成 1继续 2ERR 3KICK
        DataInputStream stream = new DataInputStream(new ByteArrayInputStream(packet.bytes));
        switch (packet.type) {
            case 106:
                for (int i0 = 0;i0 < 200;i0++) {
                    IoOutputStream out1 = new IoOutputStream();
                
                    out1.writeString("HI RW-HPS! DR!");
                    out1.writeInt(0);
                    sendPacket(socket,out1.createPacket(140));
                }

            /*
                stream.readUTF();
                stream.readInt();
                stream.readInt();
                stream.readUTF();
                stream.readInt();
                stream.readInt();
                stream.readBoolean();
                stream.readInt();
                stream.readByte();
                stream.readBoolean();
                stream.readBoolean();
                stream.readInt();
                stream.readInt();
                stream.readInt();
                stream.readFloat();
                stream.readBoolean();
                stream.readBoolean();
                stream.readBoolean();
                /**
                stream.readUTF();
                int n2;
                int n3 = stream.readInt();
                byte[] arrby = new byte[n3];
                for (int i2 = 0; i2 < n3 && (n2 = stream.read(arrby, i2, n3 - i2)) != -1; i2 += n2) {
                }
                //
                DataInputStream stream2 = new DataInputStream(new ByteArrayInputStream(arrby));
                stream2.readInt();
                int count = stream2.readInt();
                StringBuilder data = new StringBuilder();
                for (int i=0;i < count;i++) {
                    data.delete( 0, data.length() );
                    data.append(stream2.readUTF()).append("%#%").append(stream2.readInt());
                    stream2.readBoolean();
                    if (stream2.readBoolean()) {
                        data.append("%#%").append(stream2.readUTF());
                    }
                    stream2.readLong();
                    stream2.readLong();
                    System.out.println(data.toString());
                }
                */
                return 1;
            case 150:
                    System.out.println(stream.readUTF());
                    return 1;
            case 161:
                IoOutputStream out = new IoOutputStream();
                String pkgname1 = stream.readUTF();
		        int T1 = stream.readInt();
		        int version1 = stream.readInt();
		        int version2 = stream.readInt();
		        String pkgname2 = stream.readUTF();
		        String connectsha = stream.readUTF();
		        int connectkey = stream.readInt();
                out.writeString("com.corrodinggames.rts");
                out.writeInt(4);
                out.writeInt(151);
                out.writeInt(151);
                //out.writeString(connectak(connectkey));
                out.writeString("TEST BOT Auto!");

                    out.writeBoolean(false);

                out.writeString("com.corrodinggames.rts.java");
                out.writeString("2CE9E9FDD25C4042E50BC2E958D6FC78C4672616C18156E784A35912385ED5E3");
                out.writeInt(1198432602);
                out.writeString(connectak(connectkey));
                sendPacket(socket,out.createPacket(110));
                return 1;
        }
        return 3;
    }

    public static void sendPacket(Socket socket, Packet p) throws IOException {
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(p.bytes.length);
        out.writeInt(p.type);
        out.write(p.bytes);
        out.flush();
    }


public static String connectak(int paramInt) {
        StringBuffer ak = new StringBuffer(16);
        ak.append("c:" + paramInt)
              .append("m:" + (paramInt * 87 + 24))
              .append("0:" + (44000 * paramInt))
              .append("1:" + paramInt)
              .append("2:" + (13000 * paramInt))
              .append("3:" + (28000 + paramInt))
              .append("4:" + (75000 * paramInt))
              .append("5:" + (160000 + paramInt))
              .append("6:" + (850000 * paramInt))
              .append("t1:" + (44000 * paramInt))
              .append("d:" + (5 * paramInt));
        return ak.toString();
    }
    public static String ccc(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if(hex.length() < 2){
				sb.append(0);
			}
			sb.append(hex);
		}
		return sb.toString();
	}

    static class IoInputStream {
    public ByteArrayInputStream buffer;
    public DataInputStream stream;

    public IoInputStream(Packet packet) {
        this.buffer = new ByteArrayInputStream(packet.bytes);
        this.stream = new DataInputStream(this.buffer);
    }

    public int readByte() throws IOException {
        return this.stream.readByte();
    }

    public boolean readBoolean() throws IOException {
        return this.stream.readBoolean();
    }

    public int readInt() throws IOException {
        return this.stream.readInt();
    }

    public float readFloat() throws IOException {
        return this.stream.readFloat();
    }

    public long readLong() throws IOException {
        return this.stream.readLong();
    }

    public String readString() throws IOException {
        return this.stream.readUTF();
    }
}
static class IoOutputStream {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    DataOutputStream stream = new DataOutputStream(buffer);
    public Packet createPacket(int type) {
        try {
            this.stream.flush();
            this.buffer.flush();
            Packet packet = new Packet(type);
            packet.bytes = this.buffer.toByteArray();
            return packet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeByte(int val) throws IOException {
        this.stream.writeByte(val);
    }

    public void writeBoolean(boolean val) throws IOException {
        this.stream.writeBoolean(val);
    }

    public void writeInt(int val) throws IOException {
        this.stream.writeInt(val);
    }

    public void writeFloat(float val) throws IOException {
        this.stream.writeFloat(val);
    }

    public void writeLong(long val) throws IOException {
        this.stream.writeLong(val);
    }

    public void writeString(String val) throws IOException {
        this.stream.writeUTF(val);
    }
}
	
static class Packet {
  public byte[] bytes;
  
  public int type;
  
  public Packet(int paramInt) {
    this.type = paramInt;
  }
}

}
