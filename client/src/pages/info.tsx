import { Button } from '@/components/ui/button'
import '../index.css'
import { Link } from 'react-router-dom'


function Info() {
    return (
        <>
            <h1>Info</h1>
            <div className="flex flex-wrap items-center gap-2 md:flex-row">
                <Button>
                    <Link to="/">Home</Link>
                </Button>
                <Button>
                    <Link to="/Login">Login</Link>
                </Button>
                <Button>
                    <Link to="/Info">Info</Link>
                </Button>
            </div>
        </>
    )
}

export default Info