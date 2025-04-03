import axios from "axios";

const API_URL = "http://localhost:8082/compras";

export interface Compra {
    id: number;
    descripcion: string;
    fecha: string;
    total: number;
}

export const obtenerCompras = async (): Promise<Compra[]> => {
    const response = await axios.get(API_URL);
    return response.data;
};

export const filtrarCompras = async (
    id?: string,
    nombre?: string,
    fecha?: string
): Promise<Compra[]> => {
    const params: Record<string, string> = {};

    // Solo agregamos los parámetros si no son undefined o null
    if (id) params.id = id;
    if (nombre) params.nombre = nombre;
    if (fecha) params.fecha = fecha;

    // Si no se pasa ningún parámetro, se devuelve todas las compras
    if (Object.keys(params).length === 0) {
        return await obtenerCompras();  // Llama la función que trae todas las compras
    }

    const response = await axios.get(`${API_URL}/filtrar`, { params });
    return response.data;
};
