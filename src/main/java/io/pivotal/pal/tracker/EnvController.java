package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

//    assertThat(env.get("PORT")).isEqualTo("8675");
//    assertThat(env.get("MEMORY_LIMIT")).isEqualTo("12G");
//    assertThat(env.get("CF_INSTANCE_INDEX")).isEqualTo("34");
//    assertThat(env.get("CF_INSTANCE_ADDR")).isEqualTo("123.sesame.street");

    Map<String, String> env = new HashMap<>();
    String portNumber= "";
    String memoryLimit = "";
    String cfInstanceIndex = "";
    String cfInstanceAddr = "";

    public EnvController(@Value("${port:8675}") String s, @Value("${memory.limit: 12G}")  String s1, @Value("${cf.instance.index:NOT SET}")  String s2, @Value("${cf.instance.addr: NOT SET}")  String s3) {
        portNumber = s;
        memoryLimit = s1;
        cfInstanceIndex = s2;
        cfInstanceAddr = s3;
    }


   @GetMapping("/env")
    public Map<String, String> getEnv() {

        env.put("PORT", portNumber);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddr);
        return env;
    }
}
