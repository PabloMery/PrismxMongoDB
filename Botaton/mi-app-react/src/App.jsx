import { useState } from 'react'
import NavBar from './componentes/NavBar'
import Footer from './componentes/Footer'
import GraficosApex from './componentes/Graficos'
import FiltroResultados from './componentes/Filter'


function App() {
  const [count, setCount] = useState(0)

  return (
<>
  <NavBar/>
  <FiltroResultados/>
  <Filter/>
  <Footer/>
</>
  )
}

export default App
