package com.education.TDE.dto;

import java.text.DateFormat;
import java.util.Date;

public record NotaRequestDTO(Integer matricula_id, Integer disciplina_id, Float nota, Date data_lancamento) {
}
