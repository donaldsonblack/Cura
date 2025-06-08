import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'


createRoot(document.getElementById('root')!).render( // '!' asserts that document.getElementById('root') will 100% return a HTMLElement, and not null.
  <StrictMode>
    <App />
  </StrictMode>,
)
