package com.example.objectmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** ----------- Description ------------------
 * - При команда "find X" -> да върне JSON с информацията за Мениджъра + неговите подчинени
 * - При команда "findAll" -> да върне масив (JSON) с информацията за Мениджърите + техните подчинени
 * - При команда "save {firstName: "...", lastName: "...", salary: xxxx.x, address: "..."}" -> да го запишем в базата + да върнем това + id-то
 * - При команда "save-from-file (filePath)" да прочете json file и да запише в базата
 * - При команда "findAll-to (filePath)" да запише всички мениджъри във файл

 */
@SpringBootApplication
public class ObjectMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObjectMappingApplication.class, args);
    }

}
