import { render, screen } from '@testing-library/react';
import Cabecalho from './index';

test("Deve renderizar o nome do usuário logado", () =>{
   render(<Cabecalho/>); // renderiza o componente
   const nomeUsuario = screen.getByText('Joana Fonseca Gomes'); //pega algo do componente renderizado pelo JestDOM
   expect(nomeUsuario).toBeInTheDocument(); // realiza a comparação
})