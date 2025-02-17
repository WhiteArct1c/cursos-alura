import ITarefa from "../../types/ITarefa";
import Item from "./Item";
import style from "./List.module.scss";

interface Props{
   tarefas: ITarefa[];
   selecionaTarefa: (tarefa: ITarefa) => void;
}

function List({ tarefas, selecionaTarefa }: Props) {
   return (
      <aside className={style.listaTarefas}>
         <h2>Estudos do dia</h2>
         <ul>
            {
               tarefas.map((item) => {
                  return (
                     <Item
                        selecionaTarefa={selecionaTarefa}
                        key={item.id}
                        {...item}
                     />
                  );
               })
            }
         </ul>
      </aside>
   );
}

export default List;