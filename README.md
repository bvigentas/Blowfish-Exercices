
# Exercícios lista 7

## Caso 1
**1.1. Qual o conteúdo do texto cifrado (em hexadecimal)?**  
R: 7f4700aa6f5fe08b  
**1.2. Qual a extensão (quantidade de caracteres) do texto cifrado?**  
R: 8  

## Caso 2
**2.1. Qual o conteúdo do texto cifrado (em hexadecimal)?**  
R: f34739ab7634c4efe50ff1b554856572  
**2.2. Qual a extensão do texto cifrado?**  
R: 16  
**2.3. Por que o texto cifrado tem tal tamanho?**  
R: Pois o algoritmo completa o restante dos bytes para ficarem em blocos de 8  

## Caso 3
**3.1. Qual o conteúdo do texto cifrado (em hexadecimal)?**  
R: 841091472604b96acdbc3e2fefa73bdd  
**3.2. Qual a extensão do texto cifrado?**  
R: 16  
**3.3. Por que o texto cifrado tem tal tamanho?**  
R: Pois o texto em sí ocupa exatamente um bloco, mas ele precisa colocar o caracteres para descriptografar, então ele cria um novo bloco para isso.  

## Caso 4
**4.1. Qual o conteúdo do texto cifrado (em hexadecimal)?**  
R: 841091472604b96a841091472604b96a841091472604b96acdbc3e2fefa73bdd   
**4.2. Qual a extensão do texto cifrado?**  
R: 32  
**4.3. Avalie o conteúdo do texto cifrado. Que conclusão é possível obter a partir do texto cifrado e do texto simples?**  
R: Podemos ver a repetição de caracteres, como acontece com o texto simples.  

## Caso 5
**5.1. Qual o conteúdo do texto cifrado (em hexadecimal)?**  
R: 5e578be62e5296a0  
**5.2. Tente decifrar o texto cifrado, para recuperar o texto simples. O que acontece?**  
R: Ocorre um erro, pois para decifrarmos o texto precisamos do vetor de inicialização, que não é passado.  

## Caso 6
**6.1. Qual o conteúdo do texto cifrado?**  
R: cf0a75a354fb624c  

## Caso 7
**7.1. Qual o conteúdo do texto cifrado (em hexadecimal)?**  
R: 9b1813dacaf2d6509d10c55c33f36b0918d49bf6cd0c1241e1ab6d1d3119eab6  
**7.2. Compare o texto cifrado com aquele obtido no caso 4 e apresente uma conclusão desta comparação**  
R: Diferentemente do texto cifrado no caso 4, em que vemos um padrão, uma repetição nos caracteres, no gerado no caso 7 não conseguimos notar isso.   

## Caso 8
**8.1. Qual o conteúdo do texto cifrado?**  
R: 10981fe3009f1fe0ab7592179c361cc7af8eb390b79ebc8ed6a1f71d43e1c0c4  
**8.2. Compare o texto cifrado com o que foi obtido no caso 7 e apresente conclusão sobre a comparação.**  
R: O texto é completamente diferente do gerado no caso 7  
**8.3. A partir do resultado de 8.2, decriptografe a mensagem usando o vetor de inicialização constituído dos bytes 1, 1,
2, 2, 3, 3, 4, 4. Qual a conclusão que você atinge?**  
R: Ao decifrar o texto obtido no caso 8 com o vetor de inicialização obtemos o conteúdo *XT^ezSABONETESABONETE*, como podemos ver o início do texto é diferente, pois deciframos o texto com um vetor de inicialização diferente do que foi cifrado.  

## Caso 9
**9.1. Criptografe o texto “FURB” usando o modo de operação “ECB”. A partir do texto cifrado obtido, tente decifrá-lo
utilizando a chave “11111”. Explique o resultado.**  
R: Ocorre um erro, pois para decifrar um texto é necessário ter a mesma chave com que ele foi cifrado.
