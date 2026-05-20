package br.edu.ifpb.ads.padroes.atv1.notification;

public class CanalSms implements CanalNotificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}
