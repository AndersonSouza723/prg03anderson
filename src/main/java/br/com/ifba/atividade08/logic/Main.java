package br.com.ifba.atividade08.logic;

/* NOTAS PARA O PROF: Pra facilitar o entendimento de aprender tudo o que
utilizei aqui, usei uma temática de RPG de mesa, mais especificamente de vampiro: a mascara
O papel de narrador significa alguém que pode gerenciar o jogo, enquanto o de 
jogador é alguém que apenas controla seu próprio personagem, ele não tem permissões
para alterar o jogo ou gerenciar o sistema.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("===== 1. CRIANDO PERFIS E PERMISSÕES =====");

        PerfilUsuario perfilNarrador = new PerfilUsuario();
        perfilNarrador.setId(1);
        perfilNarrador.setDescricao("Narrador / Admin");
        // Misturando regras de sistema com regras de crônica!
        perfilNarrador.getPermissoes().add("GERENCIAR_SISTEMA");
        perfilNarrador.getPermissoes().add("USAR_DOMINACAO"); 

        PerfilUsuario perfilJogador = new PerfilUsuario();
        perfilJogador.setId(2);
        perfilJogador.setDescricao("Jogador / Comum");
        perfilJogador.getPermissoes().add("ACESSAR_SESSAO");
        perfilJogador.getPermissoes().add("USAR_AUSPEX");

        System.out.println("Perfis '" + perfilNarrador.getDescricao() + "' e '" + perfilJogador.getDescricao() + "' criados.\n");


        System.out.println("===== 2. CRIANDO USUÁRIOS E ASSOCIANDO PERFIS =====");

        Usuario helena = new Usuario();
        helena.setId(100);
        helena.setNomeUsuario("Helena");
        helena.setEmail("helena@saopaulobynight.com");
        helena.setSenha("senha123");
        helena.setAtivo(true);
        helena.setPerfil(perfilNarrador); 

        Usuario abigail = new Usuario();
        abigail.setId(101);
        abigail.setNomeUsuario("Abigail");
        abigail.setEmail("abigail@saopaulobynight.com");
        abigail.setSenha("abi321");
        abigail.setAtivo(true);
        abigail.setPerfil(perfilJogador);

        System.out.println("Usuários " + helena.getNomeUsuario() + " e " + abigail.getNomeUsuario() + " prontas.\n");


        System.out.println("===== 3. TESTANDO LOGS DE AUDITORIA (LOGIN) =====");
        
        System.out.println("-> Helena tentando logar com a senha ERRADA:");
        helena.fazerLogin("senhaErrada"); // Vai gerar log de erro
        
        System.out.println("\n-> Helena tentando logar com a senha CERTA:");
        helena.fazerLogin("senha123");    // Vai gerar log de sucesso

        System.out.println("\n-> Abigail tentando logar com a senha CERTA:");
        abigail.fazerLogin("abi321");     // Vai gerar log de sucesso


        System.out.println("\n===== 4. CRIANDO SESSÕES =====");
        
        System.out.println("-> Iniciando sessão para Helena...");
        // Passando a própria Helena como parâmetro devido à assinatura do método
        helena.criarSessao(helena); 
        
        System.out.println("-> Iniciando sessão para Abigail...");
        abigail.criarSessao(abigail);


        System.out.println("\n===== 5. RELATÓRIO FINAL DO TESTE =====");
        
        // Imprimindo a Helena e suas listas
        System.out.println(helena);
        System.out.println("--- Sessões Ativas da Helena (" + helena.getSessoes().size() + ") ---");
        for (Sessao s : helena.getSessoes()) {
            System.out.println("ID Sessão: " + s.getId() + " | Token: " + s.getToken());
        }
        System.out.println("--- Logs da Helena (" + helena.getLogs().size() + ") ---");
        for (LogAuditoria log : helena.getLogs()) {
            System.out.println(log.toString());
        }

        System.out.println("\n====================================================");
        
        // Imprimindo a Abigail e suas listas
        System.out.println(abigail);
        System.out.println("--- Sessões Ativas da Abigail (" + abigail.getSessoes().size() + ") ---");
        for (Sessao s : abigail.getSessoes()) {
            System.out.println("ID Sessão: " + s.getId() + " | Token: " + s.getToken());
        }
        System.out.println("--- Logs da Abigail (" + abigail.getLogs().size() + ") ---");
        for (LogAuditoria log : abigail.getLogs()) {
            System.out.println("[" + log.getDataHora() + "] IP: " + log.getIp() + " | Ação: " + log.getAcao());
        }
    }
}
