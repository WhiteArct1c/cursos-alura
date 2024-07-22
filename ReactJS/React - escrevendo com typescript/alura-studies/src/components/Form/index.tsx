import React from "react";
import Button from "../Button";
import style from "./Form.module.scss";
import ITarefa from "../../types/ITarefa";
import {v4 as uuidv4 } from "uuid";

interface Props {
  setTarefas: React.Dispatch<React.SetStateAction<ITarefa[]>>;
}

function Form({ setTarefas }: Props) {
  const [tarefa, setTarefa] = React.useState("");
  const [tempo, setTempo] = React.useState("00:00:00");


  function adicionarTarefa(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    setTarefas(tarefasAntigas => 
      [
        ...tarefasAntigas, 
        {
          tarefa,
          tempo,
          selecionado: false,
          completado: false,
          id: uuidv4()
        }
      ]
    )
    setTarefa("");
    setTempo("00:00:00");
  }
  return (
    <form className={style.novaTarefa} onSubmit={adicionarTarefa}>
      <div className={style.inputContainer}>
          <label htmlFor="tarefa">Adicione um novo estudo</label>
          <input
              type="text"
              name="tarefa"
              id="tarefa"
              value={tarefa}
              onChange={(event) => setTarefa(event.target.value)}
              placeholder="O que você quer estudar?"
              required
          />
      </div>
      <div className={style.inputContainer}>
          <label htmlFor="name">Tempo</label>
          <input
              type="time"
              step="1"
              name="tempo"
              value={tempo}
              onChange={(event) => setTempo(event.target.value)}
              id="tempo"
              min="00:00:00"
              max="24:00:00"
              required
          />
      </div>
      <Button type="submit">
          Adicionar
      </Button>
    </form>
  );
}

export default Form;