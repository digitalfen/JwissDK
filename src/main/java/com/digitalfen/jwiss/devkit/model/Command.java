package com.digitalfen.jwiss.devkit.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JwissTool Command Argument model
 * 
 * @value usage String
 * @value parentName String
 * @value arguments List<Argument>
 */
@Getter
@Setter
@NoArgsConstructor
public class Command {

    private String usage;
    private String parentName;
    private List<Argument> arguments;

}
