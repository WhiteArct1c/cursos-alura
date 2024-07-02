import {render, screen} from '@testing-library/react';
import Menu from './index';

test('Deve renderizar um link para a página inicial', () =>{
   render(<Menu/>);
   const homeLink = screen.getByText('Inicial');
   expect(homeLink).toBeInTheDocument();
});

test('Deve renderizar uma lista de links', () =>{
   render(<Menu/>);
   const listaDeLinks = screen.getAllByRole('link');
   expect(listaDeLinks).toHaveLength(4);
});

test('Não deve renderizar o link para o Extrato', () =>{
   render(<Menu/>);
   const listaExtrato = screen.queryByText('Extrato');
   expect(listaExtrato).not.toBeInTheDocument();
});

test('Deve renderizar uma lista de links com a classe link', () =>{
   render(<Menu/>);
   const menuItens = screen.getAllByRole('link');
   menuItens.forEach(item => {
      expect(item).toHaveClass('link');
   });
   expect(menuItens).toMatchSnapshot();
})