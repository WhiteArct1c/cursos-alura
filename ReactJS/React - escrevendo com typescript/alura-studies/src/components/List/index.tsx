import React from "react";
import "./style.scss";

function List() {
   const tarefas = [{
      nome: "React",
      tempo: "02:00:00"
   }, {
      nome: "Javascript",
      tempo: "01:00:00"
   }, {
      nome: "Typescript",
      tempo: "00:30:00"
   }];

   return (
      <aside className="listaTarefas">
         <h2>Estudos do dia</h2>
         <ul>
            {
               tarefas.map((item, index) => {
                  return (
                     <li key={index} className="item">
                        <h3>{item.nome}</h3>
                        <span>{item.tempo}</span>
                     </li>
                  );
               })
            }
         </ul>
      </aside>
   );
}

export default List;