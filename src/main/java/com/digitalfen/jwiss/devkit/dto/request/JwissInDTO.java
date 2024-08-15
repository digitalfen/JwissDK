package com.digitalfen.jwiss.devkit.dto.request;

import java.util.List;

import com.digitalfen.jwiss.devkit.model.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for input data in JwissTool
 * 
 * @value commands List<Command>
 */
@Getter
@Setter
@NoArgsConstructor
public class JwissInDTO {

    private List<Command> commands;

}
