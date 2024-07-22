import { useEffect, useState } from "react";
import ITarefa from "../../types/ITarefa";
import Button from "../Button";
import Relogio from "../Relogio";
import style from "./Cronometro.module.scss";
import { tempoParaSegundos } from "../../common/utils/time";

export interface Props{
   selecionado: ITarefa | undefined;
   finalizarTarefa: () => void;
}

export default function Cronometro({selecionado, finalizarTarefa}: Props) {

   const [tempo, setTempo] = useState<number>();

   useEffect(() => {
      if(selecionado){
         setTempo(tempoParaSegundos(selecionado.tempo));
      }
   }, [selecionado]);

   function contador(tempo: number = 0){
      setTimeout(() => {
         if(tempo > 0){
            setTempo(tempo - 1);
            return contador(tempo - 1);
         }
         finalizarTarefa();
      }, 1000);
   }

   return(
      <div className={style.cronometro}>
         <p className={style.titulo}>Escolha um card e inicie o cronometro</p>
         <div className={style.relogioWrapper}>
            <Relogio tempo={tempo}/>
         </div>
         <Button onClick={() => contador(tempo)}>
            Começar!
         </Button>
      </div>
   )
}