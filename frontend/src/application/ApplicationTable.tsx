import { useEffect, useState } from 'react'
import { getApplications } from './applicationApi'
import type { Application } from './applicationDto'

function ApplicationTable() {
  const [applications, setApplications] = useState<Application[]>([])
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    const fetchApplications = async () => {
      try {
        setApplications(await getApplications())
      } catch (error) {
        setError(error instanceof Error ? error.message : 'Failed to fetch applications')
      }
    }

    void fetchApplications()
  }, [])

  return (
    <>
      {error && <p role="alert">{error}</p>}
      <table>
        <thead>
          <tr>
            <th>Company</th>
            <th>Job title</th>
            <th>Location</th>
            <th>Status</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {applications.map((application) => (
            <tr key={application.id}>
              <td>{application.company}</td>
              <td>{application.jobTitle}</td>
              <td>{application.location}</td>
              <td>{application.status}</td>
              <td>{application.date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  )
}

export default ApplicationTable
