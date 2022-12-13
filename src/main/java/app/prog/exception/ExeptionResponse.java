package app.prog.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class ExeptionResponse {
    private String messege;
    private String status;
}
