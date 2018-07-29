package demo;

import org.apache.commons.io.IOUtils;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.nio.charset.Charset;

public class Hello {

    public static void main(String[] args) throws IOException {
        String md = readMarkdownFile();
        Parser parser = Parser.builder().build();
        Node document = parser.parse(md);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html = renderer.render(document);
        System.out.println(html);
    }
    private static String readMarkdownFile() throws IOException {
        return IOUtils.toString(Hello.class.getClassLoader().getResourceAsStream("hello.md"), Charset.defaultCharset());
    }

}
