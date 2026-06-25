import React from 'react';
import ProfissionalForm from './components/ProfissionalForm';
import AtendimentoForm from './components/AtendimentoForm';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>Sistema de Gestão - Clínica</h1>
      
      <div style={{ display: 'flex', gap: '50px', flexWrap: 'wrap' }}>
        <ProfissionalForm />
        <AtendimentoForm />
      </div>
    </div>
  );
}

export default App;