import axios from 'axios';

// Configuração base da API
const api = axios.create({
  baseURL: 'http://localhost:8080/api', 
});

// ==========================================
// SERVIÇOS: PROFISSIONAL DE SAÚDE
// ==========================================
export const profissionalService = {
  inserir: (id, dados) => api.post(`/profissionais/${id}`, dados),
  consultarPorId: (id) => api.get(`/profissionais/${id}`),
  consultarPorNome: (nome) => api.get(`/profissionais/nome/${nome}`),
  consultarPorCategoria: (categoria) => api.get(`/profissionais/categoria/${categoria}`),
  alterar: (id, dados) => api.put(`/profissionais/${id}`, dados),
  excluir: (id) => api.delete(`/profissionais/${id}`),
};

// ==========================================
// SERVIÇOS: ATENDIMENTOS
// ==========================================
export const atendimentoService = {
  inserir: (dados) => api.post(`/atendimentos`, dados),
  consultarTodos: () => api.get(`/atendimentos`),
  consultarPorId: (id) => api.get(`/atendimentos/${id}`),
  alterar: (id, dados) => api.put(`/atendimentos/${id}`, dados),
  excluir: (id) => api.delete(`/atendimentos/${id}`),
};

export default api;