package org.example;

import org.example.dto.FooDto;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExpressionParser parser = new SpelExpressionParser();

        String name = parser.parseExpression("null?:'Unknown'").getValue(String.class);

        System.out.println(name);  // 'Unknown'

        Map<String, String> map = new HashMap<>();
        map.put("key", "1");
        FooDto dto = new FooDto();
        dto.setMap(map);

        Boolean success = parser.parseExpression("map['key'] == '1'").getValue(dto, Boolean.class);
        Boolean fail = parser.parseExpression("map['unknown'] == '1'").getValue(dto, Boolean.class);

        System.out.println("map['key'] == '1': " + success);
        System.out.println("map['unknown'] == '1': " + fail);
        System.out.println();
    }
}
