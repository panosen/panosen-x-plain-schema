package com.panosen.localconfig.mysql;

import com.panosen.plainschema.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PlainParserTest {

    @Test
    public void test() throws URISyntaxException, IOException {

        URL mm = this.getClass().getClassLoader().getResource("sample.json");
        Path path = Paths.get(mm.toURI());
        List<String> lines = Files.readAllLines(path);
        String json1 = String.join("", lines);

        Plain plain = new PlainParser().parse(json1);

        PlainMap plainMap = (PlainMap) plain;

        Assert.assertEquals(5, plainMap.getMap().size());
        Assert.assertEquals("tom", ((PlainValue) plainMap.getMap().get("name")).getValue().getAsString());
        Assert.assertEquals(17, ((PlainValue) plainMap.getMap().get("age")).getValue().getAsInt());
        Assert.assertNull(plainMap.getMap().get("other"));

        PlainArray plainArray = (PlainArray) plainMap.getMap().get("scores");
        Assert.assertEquals(3, plainArray.getItems().size());
        Assert.assertEquals(1, ((PlainValue) plainArray.getItems().get(0)).getValue().getAsInt());
        Assert.assertNull(plainArray.getItems().get(1));
        Assert.assertEquals("2", ((PlainValue) plainArray.getItems().get(2)).getValue().getAsString());


        PlainMap plainMap1 = (PlainMap) plainMap.getMap().get("items");
        Assert.assertEquals(2, plainMap1.getMap().size());
        Assert.assertEquals("a1",((PlainValue)plainMap1.getMap().get("a")).getValue().getAsString());
        Assert.assertEquals(11,((PlainValue)plainMap1.getMap().get("b")).getValue().getAsInt());
    }
}