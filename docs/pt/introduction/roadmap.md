# Plano de desenvolvimento

Como o *LifeUp* é mantido atualmente em tempo livre e com recursos limitados, não garantimos que o plano de desenvolvimento possa ser executado com precisão, e não prometemos um horário específico de lançamento.

<br/>

## Estratégia de atualização

O ciclo de atualização de recursos locais permanecerá entre 14 e 21 dias.

E após cada atualização de recurso, podemos lançar várias correções.

Como a função do módulo "Mundo" envolve vários fatores, como desenvolvimento conjunto em duas plataformas, sincronização de requisitos, implantação de servidor, limitações de desempenho do servidor e compatibilidade.

O ciclo de desenvolvimento será mais longo que o de funções locais e será principalmente de manutenção, em vez de introduzir novos recursos.



**Prioridade de atualização (aproximadamente):**

Correções de bugs de crash >> Correções de bugs de experiência que afetam novos usuários >> Atualizações de recursos > Correções de bugs de UI e detalhes.

<br/>

## Estratégia de numeração de versão

Usamos um número de versão de três dígitos, como `1.80.3`.

**O primeiro** (como **1**.80.3) é o número de versão usado para a revisão principal da aplicação, e 1 é a versão oficial inicial. Haverá muitas refatorações de código/redesigns de UI se isso trouxer melhorias.


**O dígito do meio** (como 1.**80**.3) é o número de versão de recurso (feature). O número de versão aumentará quando um recurso de nível médio for lançado ou quando um número relativamente grande de recursos menores for acumulado.

Por exemplo:

> A versão 64 lançou o sistema Loja & Armazém & Depósito.
>
> A versão 70 lançou o Modo Simples.
>
> A versão 80 lançou o sistema de abertura de Caixas de saque.



**O terceiro dígito** (por exemplo, 1.80.**3**) é o número de revisão para corrigir alguns problemas/crashes a cada lançamento de recurso. Ao mesmo tempo, também pode trazer alguns recursos menores.


> A versão antiga também usava número de versão de três dígitos representado por letras em inglês, como 1.58c.
>
> A estratégia básica é a mesma acima, exceto que a terceira seção vira uma letra em inglês e começa em `a`.
>
> No entanto, como alguns mercados de aplicativos não suportam essa estratégia de numeração de versão, ela foi abandonada.

<br/>

Consulte o [Plano de desenvolvimento 2026-2027](introduction/development_plan_2026_2027.md) para nosso roadmap atual.

Consulte o [Plano de desenvolvimento 2024-2025](introduction/development_plan_2024.md) para o roadmap anterior.

Consulte o [Plano de desenvolvimento 2022/10 - 2023/12](introduction/development_plan_2023.md) para o arquivo histórico.
