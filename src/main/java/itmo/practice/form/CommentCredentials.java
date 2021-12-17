package itmo.practice.form;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CommentCredentials {
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 650)
    @Lob
    private String text;

    private String login;

    public static String encode(String text) {
        String PKey = "4MxCi0bq4E";
        StringBuilder nText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            c ^= PKey.charAt(i % PKey.length());
            nText.append(c);
        }
        return nText.toString();
    }
}