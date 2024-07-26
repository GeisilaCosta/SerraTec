import { Routes, Route } from "react-router-dom";
import { Contador } from "../pages/contador/contador";
import { ListaDePokemons } from "../pages/listaDePokemons/ListaDePokemons";
import { HomePage } from "../pages/homePage/HomePage";

export function Rotas() {
    return (
        <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/contador" element={<Contador />} />
            <Route path="/lista-de-pokemon" element={<ListaDePokemons />} />
        </Routes>
    );
}