import React, {useEffect, useState} from 'react';


interface Compra {
    id: number;
    descripcion: string;
    fecha: string;
    total: number;
    nombre:string;
}

const ApiComponent: React.FC = () => {
    const [id, setId] = useState<string>(''); // ID del filtro
    const [compras, setCompras] = useState<Compra[]>([]); // Para almacenar las compras
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    const filtrarCompras = async () => {
        const params: Record<string, string> = {};
        if (id) params.id = id;

        try {
            const response = await fetch(`http://localhost:8082/compras/filtrar?${new URLSearchParams(params).toString()}`);
            if (!response.ok) {
                throw new Error('Error al obtener las compras');
            }
            const result: Compra[] = await response.json();
            setCompras(result);
        } catch (error) {
            setError(error instanceof Error ? error.message : 'Error desconocido');
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        filtrarCompras();
    }, [id]); // Refiltrar cuando cambie el ID

    if (loading) {
        return <div className="loading">Cargando...</div>;
    }

    if (error) {
        return <div className="error">Error: {error}</div>;
    }

    return (
        <div className="api-component">
            <h1>Filtrar Compras</h1>

            <div className="filter-input">
                <input
                    type="text"
                    placeholder="ID"
                    value={id}
                    onChange={(e) => setId(e.target.value)}
                />

            </div>

            <h2>Lista de Compras</h2>
            <ul className="compras-list">
                {compras.map((compra) => (
                    <li key={compra.id}>
                        {compra.descripcion} - {compra.fecha} - ${compra.total}- ${compra.nombre}

                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ApiComponent;
