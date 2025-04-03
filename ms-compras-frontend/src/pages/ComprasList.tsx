import { useEffect, useState } from "react";
import { obtenerCompras } from "../Api/compras";
import type { Compra } from "../Api/compras";



export default function ComprasList() {
    const [compras, setCompras] = useState<Compra[]>([]);

    useEffect(() => {
        obtenerCompras().then(setCompras);
    }, []);

    return (
        <div>
            <h1>Lista de Compras</h1>
            <ul>
                {compras.map((compra) => (
                    <li key={compra.id}>
                        {compra.descripcion} - {compra.fecha} - ${compra.total}
                    </li>
                ))}
            </ul>
        </div>
    );
}
