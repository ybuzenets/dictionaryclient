package dev.buzenets.dictionary.client;

import com.beust.jcommander.JCommander;
import dev.buzenets.dictionary.client.cli.Args;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.logging.Logger;

public class Client {
    private static final Logger LOG = Logger.getLogger(Client.class.getName());

    public static void main(String[] argv) {
        final Args args = new Args();
        JCommander.newBuilder()
            .addObject(args)
            .build()
            .parse(argv);
        try (
            Socket socket = new Socket(args.getAddress(), args.getPort());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            oos.writeUTF(Charset.defaultCharset().name());
            oos.writeUTF(args.getCommand());
            oos.writeObject(args.getArgs());
            bufferedReader.lines()
                .forEach(LOG::info);
        } catch (IOException e) {
            LOG.severe(e::getMessage);
        }
    }
}
