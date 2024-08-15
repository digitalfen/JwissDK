package com.digitalfen.jwiss.devkit.dto.request;

import java.util.List;

import com.digitalfen.jwiss.devkit.model.JwissCommand;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwissInDTO {

    private List<JwissCommand> commands;

}
