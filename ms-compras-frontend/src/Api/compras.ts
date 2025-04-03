const API_URL = "http://localhost:8082/compras";
// Cambia el puerto si es necesario

export async function obtenerCompras() {
    const response = await fetch(API_URL);
    if (!response.ok) throw new Error("Error al obtener compras");
    return response.json();
}
export interface Compra {
    id: number;
    descripcion: string;
    fecha: string;
    total: number;
}
