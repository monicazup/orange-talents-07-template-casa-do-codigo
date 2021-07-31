package br.com.zupacademy.OT7.monica.casadocodigo.config;

import java.util.Collection;

public class ErroPadronizado {
    Collection<String> messages;

    public ErroPadronizado(Collection<String> messages) {
        this.messages = messages;
    }

    public Collection<String> getMessages() {
        return messages;
    }

    public void setMessages(Collection<String> messages) {
        this.messages = messages;
    }
}
