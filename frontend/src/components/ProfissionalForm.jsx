import React, { useState } from 'react';
import { profissionalService } from '../services/api';

const ProfissionalForm = () => {
  const [formData, setFormData] = useState({
    id: '',
    nome: '',
    telefone: '',
    endereco: '',
    categoria: 'MEDICO'
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await profissionalService.inserir(formData.id, formData);
      alert('Profissional cadastrado com sucesso!');
      setFormData({ id: '', nome: '', telefone: '', endereco: '', categoria: 'MEDICO' });
    } catch (error) {
      console.error("Erro ao cadastrar profissional:", error);
      alert('Erro ao cadastrar. Verifique o console ou se o backend está rodando.');
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: '0 auto', border: '1px solid #ccc', padding: '20px', borderRadius: '8px' }}>
      <h2>Cadastro de Profissional</h2>
      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
        
        <label>ID (Manual):</label>
        <input type="number" name="id" value={formData.id} onChange={handleChange} required />

        <label>Nome:</label>
        <input type="text" name="nome" value={formData.nome} onChange={handleChange} required maxLength="100" />

        <label>Telefone:</label>
        <input type="text" name="telefone" value={formData.telefone} onChange={handleChange} maxLength="20" />

        <label>Endereço:</label>
        <input type="text" name="endereco" value={formData.endereco} onChange={handleChange} maxLength="200" />

        <label>Categoria:</label>
        <select name="categoria" value={formData.categoria} onChange={handleChange} required>
          <option value="MEDICO">Médico</option>
          <option value="PSICOLOGO">Psicólogo</option>
          <option value="FISIOTERAPEUTA">Fisioterapeuta</option>
        </select>

        <button type="submit" style={{ marginTop: '10px', padding: '10px', cursor: 'pointer' }}>Salvar Profissional</button>
      </form>
    </div>
  );
};

export default ProfissionalForm;