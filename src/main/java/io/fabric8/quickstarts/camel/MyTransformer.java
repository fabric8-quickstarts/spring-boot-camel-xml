/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.quickstarts.camel;

import org.springframework.stereotype.Component;

/**
 * A sample transform
 */
@Component(value = "myTransformer")
public class MyTransformer {

    public String transform() {
        // lets return a random string
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            int number = (int) (Math.round(Math.random() * 1000) % 10);
            char letter = (char) ('0' + number);
            buffer.append(letter);
        }
        return buffer.toString();
    }

}
