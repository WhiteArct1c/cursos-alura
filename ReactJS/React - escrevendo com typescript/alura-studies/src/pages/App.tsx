import { useState } from 'react';
import Cronometro from '../components/Cronometro';
import Form from '../components/Form';
import List from '../components/List';
import style from './App.module.scss';
import ITarefa from '../types/ITarefa';

function App() {
  const [tarefas, setTarefa] = useState<ITarefa[]>([]);
  const [selecionado, setSelecionado] = useState<ITarefa>();

  function selecionarTarefa(tarefaSelecionada: ITarefa) {
    setSelecionado(tarefaSelecionada);
    setTarefa(tarefas.map((tarefa) => {
      return {
        ...tarefa,
        selecionado: tarefa.id === tarefaSelecionada.id ? true : false
      }
    }));
  }

  function finalizarTarefa() {
    if(selecionado){
      setSelecionado(undefined);
      setTarefa(tarefasAnteriores => 
        tarefasAnteriores.map((tarefa) => {
          if(tarefa.id === selecionado.id){
            return {
              ...tarefa,
              completado: true,
              selecionado: false
            }
          } 
          return tarefa;
        }));
    }
  }

  return (
    <div className={style.AppStyle}>
      <Form setTarefas={setTarefa}/>
      <List 
        tarefas={tarefas}
        selecionaTarefa={selecionarTarefa}
      />
      <Cronometro 
        selecionado={selecionado}
        finalizarTarefa={finalizarTarefa}
      />
    </div>
  )
}

export default App
