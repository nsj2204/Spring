package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

// Spring 자동생성 어노테이션 - @Controller, @Component, @Service, @Repository, @RestController, @Advice
// root-context.xml에 자동설정이 되어있어야 한다. <annotation-driven /> <context:component-scan base-package="org.zerock" />
@Component
@Data // vo 객체 생각해라. Setter/Getter/ToString
public class Chef {

}
