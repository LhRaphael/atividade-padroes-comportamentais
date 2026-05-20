package br.edu.ifpb.ads.padroes.atv1.notification;

/**
 * Strategy para envio de notificações.
 */
public interface CanalNotificacao {
    void enviar(String mensagem);
}
