package giovanni.validation.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewAuthorDTO(

        @NotEmpty(message = "Il nome è un dato obbligatorio!")
        @Size(min = 3, max = 40, message = "Il nome proprio deve essere compreso tra i 3 ed i 40 caratteri!")
        String name,

        @NotEmpty(message = "Il cognome è un dato obbligatorio!")
        @Size(min = 3, max = 40, message = "Il cognome deve essere compreso tra i 3 ed i 40 caratteri!")
        String surname,

        @NotEmpty(message = "L'email è un dato obbligatorio!")
        @Email(message = "L'email inserita non è valida!")
        String email,

        @NotEmpty(message = "La password è un dato obbligatorio!")
        @Size(min = 10, max = 10, message = "La data di nascita non è valida")
        String dateOfBirth
) {}


