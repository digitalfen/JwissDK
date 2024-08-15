package com.digitalfen.jwiss.devkit.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwissCommand {

    private String usage;
    private String parentName;
    private List<JwissArgument> arguments;

}
