<h1> Trabalho da disciplina: Linguagem de Programação II </h1>

<h3> Descrição </h3>

Trabalho da Unidade 2 da disciplina **Linguagem de Programação II**, implementando um sistema que lê números de um arquivo `.txt` e os armazena em uma estrutura de dados genérica escolhida (Árvore Binária de Busca).

O projeto utiliza anotações (`@Processar` e `@Acao`) e reflexão para identificar e executar automaticamente métodos sobre os elementos da estrutura. Inclui tratamento completo de exceções (arquivo inexistente, formato inválido, regra de negócio para números negativos ou zero) e percorre corretamente a estrutura (in-order no caso da árvore).

---
<h3> Funcionalidades </h3>

* Leitura de números de arquivos `.txt` e inserção em estrutura genérica.
* Estrutura de dados genérica implementada (Árvore Binária de Busca).
* Descoberta automática de métodos anotados com `@Acao` via Reflection.
* Execução automática das ações sobre os elementos da estrutura (ex.: dobrar valores, imprimir).
* Tratamento completo de exceções:

  * Arquivo inexistente: `"Erro: arquivo não encontrado."`
  * Erro de reflexão: `"Erro ao usar reflexão."`
  * Dados inválidos (não inteiros): `"Erro: formato inválido. Use apenas inteiros."`
  * Regra de negócio (números ≤ 0): `"Erro: número não permitido pela regra de negócio."`

---

<h2> Como usar </h2>

<h3> 1. Preparar o arquivo de entrada </h3>

Crie um arquivo `.txt` na pasta de database do projeto, o qual conterá números inteiros positivos, um por linha.
```
Exemplo (`numeros.txt`):

5
10
3
8
```

---
<h3> 2. Executar o programa</h3>
    Digite o nome do arquivo seguido de ".txt".
    
    Exemplo: `arquivo.txt`
    
---

<h3> 3. Visualizar a execução</h3>

* O programa irá inserir os números válidos na árvore.
* Executar automaticamente os métodos anotados (`@Acao`) na ordem correta (in-order para árvore).
* Imprimir resultados ou dobrar valores conforme definido nos métodos da classe `Operacoes`.

---

<h2> Estrutura do projeto</h2>

<ul>
  <li><strong>src</strong>
    <ul>
      <li>anotacoes
        <ul>
          <li>Acao.java</li>
          <li>Processar.java</li>
        </ul>
      </li>
      <li>app
        <ul>
          <li>Main.java</li>
        </ul>
      </li>
      <li>arvore_bst_numeros
        <ul>
          <li>ArvoreBST.java</li>
          <li>No.java</li>
        </ul>
      </li>
      <li>database
        <ul>
          <li>Aqui ficarão os arquivos a serem lidos.</li>
        </ul>
      </li>
      <li>exceptions
        <ul>
          <li>ArquivoNaoEncontradoException.java</li>
          <li>ErroNaReflexaoException.java</li>
          <li>NumeroNegativoOuNuloException.java</li>
        </ul>
      </li>
      <li>manipular_arquivo
        <ul>
          <li>ListaArquivos.java</li>
          <li>ManipuladorArquivo.java</li>
        </ul>
      </li>
      <li>operacoes
        <ul>
          <li>Operacoes.java</li>
          <li>Processador.java</li>
        </ul>
      </li>
    </ul>
  </li>
</ul>

---
<h2>Colaboradores: </h2>
Este projeto possui por colaborador (principais desenvolvedor):
<ul>
    <li>Juvam Rodrigues do Nascimento Neto (https://github.com/Juvam-Rodrigues).</li>
</ul>
